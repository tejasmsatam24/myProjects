//
//  ShortWalkViewController.swift
//  NIU Campus Walk v3
//
//  Created by Tejas Satam on 11/28/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit
import MapKit
import CoreLocation
//Creating objects using structure and appending the JSON data to array
struct ShortWalkBuildings: Decodable {
    var Number : String?
    let BuildingName : String?
    let BuildingCode : String?
    let City : String?
    let State : String?
    let Latitude : String?
    let Longitude : String?
    let BuildingImage : String?
    let Facts : String?
    
}
//creatin a class so we can create a custom pin
class customPin1: NSObject, MKAnnotation
{
    var coordinate: CLLocationCoordinate2D
    var title : String?
    var subtitle: String?
    init(pinTitle: String, pinSubtitle: String, location: CLLocationCoordinate2D) {
        self.title = pinTitle
        self.subtitle = pinSubtitle
        self.coordinate = location
    }
}

class ShortWalkViewController: UIViewController, MKMapViewDelegate, CLLocationManagerDelegate {
    //creating array to store the data
    var buildingObject1 = [ShortWalkBuildings]()
    @IBOutlet weak var mapView1: MKMapView!
    //creating a location manager, it will help us get the current location
    let manager = CLLocationManager()
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        // This will display the current location on the map
        let location = locations[0]
        let span:MKCoordinateSpan = MKCoordinateSpanMake(0.005,0.005)
        let myLocation:CLLocationCoordinate2D = CLLocationCoordinate2DMake(location.coordinate.longitude, location.coordinate.latitude)
        let region:MKCoordinateRegion = MKCoordinateRegionMake(myLocation, span)
        mapView1.setRegion(region, animated: true)
        self.mapView1.showsUserLocation = true
        
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        manager.delegate = self
        manager.desiredAccuracy = kCLLocationAccuracyBest
        manager.requestWhenInUseAuthorization()
        manager.startUpdatingLocation()
        fetchJasonData()
        //calling the main thred
        DispatchQueue.main.async {
            self.pins1()
            self.forLoop()
        }
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    //This function will fetch the JSON data
    func fetchJasonData() {
        let api_url = "http://faculty.cs.niu.edu/~krush/f18/niucampus-json"
        guard let url = URL(string: api_url) else {return}
        URLSession.shared.dataTask(with: url) { (data, response, err) in
            
            guard let json = data else { return }
            
            do {
                let buildingR = try Array (JSONDecoder().decode([[String:[ShortWalkBuildings]]].self, from: json))
                
                for (key,value) in buildingR[0]{
                    for i in value {
                        self.buildingObject1.append(i)
                    }
                }
            }
            catch let jsonErr {
                print("Error Reading JSON: ", jsonErr)
            }
            }.resume()
        
    }
     //This function will plot the pins
    func pins1() {
        print("pins")
        for i in self.buildingObject1
        {
            
            let location = CLLocationCoordinate2D(latitude: Double(i.Latitude!)!, longitude: Double(i.Longitude!)!)
            let region = MKCoordinateRegion(center: location, span: MKCoordinateSpan(latitudeDelta: 0.05, longitudeDelta: 0.05))
            self.mapView1.setRegion(region, animated: true)
            let pin = customPin(pinTitle: i.BuildingName!, pinSubtitle: i.BuildingCode!, location: location)
            //Here we are using if conditions because we dont need to plot all the pins
            if(i.Number == "12")
            {
            self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "14")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "10")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "13")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "2")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "22")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "23")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "28")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "17")
            {
                self.mapView1.addAnnotation(pin)
            }
            else if(i.Number == "16")
            {
                self.mapView1.addAnnotation(pin)
            }
            self.mapView1.delegate = self
            }
    }
    //This function will draw the polyline from on annotation pin to another
    func forLoop()
    {
        
        for i in 0..<buildingObject1.count
        {
            //we will run the loop until we are on the second last pin as we are drawing polyline from an annotion pin to the next annotation pin
            if(i < buildingObject1.count-1)
            {
                let sourceLocation = CLLocationCoordinate2D(latitude: Double(buildingObject1[i].Latitude!)! , longitude: Double(buildingObject1[i].Longitude!)!)
                let destinationLocation = CLLocationCoordinate2D(latitude: Double(buildingObject1[i+1].Latitude!)! , longitude: Double(buildingObject1[i+1].Longitude!)!)
                let sourcePlaceMark = MKPlacemark(coordinate: sourceLocation)
                let destinationPlaceMark = MKPlacemark(coordinate: destinationLocation)
                let directionRequest = MKDirectionsRequest()
                directionRequest.source = MKMapItem(placemark: sourcePlaceMark)
                directionRequest.destination = MKMapItem(placemark: destinationPlaceMark)
                directionRequest.transportType = .automobile
                let directions = MKDirections(request: directionRequest)
                directions.calculate{(response, error) in
                    guard let directResonse = response else
                    {
                        if let error = error
                        {
                            print("Error==\(error.localizedDescription)")
                        }
                        return
                    }
                    let route = directResonse.routes[0]
                    self.mapView1.add(route.polyline, level: .aboveRoads)
                    let rect = route.polyline.boundingMapRect
                    self.mapView1.setRegion(MKCoordinateRegionForMapRect(rect), animated: true)
                    
                }
            }
        }
    }
    //This function is for getting the annotation view
    func mapView(_ mapView1: MKMapView, viewFor annotation: MKAnnotation) -> MKAnnotationView? {
        if annotation is MKUserLocation
        {
            return nil
        }
        let annotationView = MKAnnotationView(annotation: annotation, reuseIdentifier: "customannotation")
        annotationView.image = UIImage(named:"pin")
        let btn = UIButton(type: .infoLight)
        annotationView.rightCalloutAccessoryView = btn
        annotationView.canShowCallout = true
        return annotationView
    }
    
//This function will pass the data to Detail View Controller when we tap on annotation view
    func mapView(_ mapView1: MKMapView, annotationView view: MKAnnotationView, calloutAccessoryControlTapped control: UIControl)
    {
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let destinationVC =  storyboard.instantiateViewController(withIdentifier: "detail") as! DetailsViewController
        
        for loc in buildingObject1 {
            
            if(view.annotation?.title == loc.BuildingName){
                destinationVC.Name = loc.BuildingName
                destinationVC.Facts = loc.Facts
                destinationVC.Image = loc.BuildingImage
            }
        }
        
        //performSegue(withIdentifier: "show", sender: self)
        
        //self.present(destinationVC, animated: true, completion: nil)
        
        self.navigationController?.pushViewController(destinationVC, animated: true)
    }
    
    func mapView(_ mapView: MKMapView, rendererFor overlay: MKOverlay) -> MKOverlayRenderer {
        let render = MKPolylineRenderer(overlay: overlay)
        render.strokeColor = UIColor.red
        render.lineWidth = 4.0
        return render
    }
    
    
    
    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }


}

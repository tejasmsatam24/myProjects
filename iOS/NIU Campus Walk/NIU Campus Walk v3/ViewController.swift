//
//  ViewController.swift
//  NIU Campus Walk v3
//
//  Created by Tejas Satam on 11/26/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
/*
    Tejas Satam
    Olsi Shehu
 */

import UIKit
import MapKit
//For using the location manager we will need to import the corelocation
import CoreLocation
//Creating objects using structure and appending the JSON data to array
struct Buildings: Decodable {
    let Number : String?
    let BuildingName : String?
    let BuildingCode : String?
    let City : String?
    let State : String?
    let Latitude : String?
    let Longitude : String?
    let BuildingImage : String?
    let Facts : String?
    
}

class customPin: NSObject, MKAnnotation
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

class ViewController: UIViewController, MKMapViewDelegate, CLLocationManagerDelegate {
    //creating array to store the data
     var buildingObject = [Buildings]()
    //creating outlet of the mapview
    @IBOutlet weak var mapView: MKMapView!
    //creating a location manager, it will help us get the current location
    let locMgr = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        locMgr.delegate = self
        locMgr.desiredAccuracy = kCLLocationAccuracyBest
        locMgr.requestWhenInUseAuthorization()
        //calling this function to fetch the data
        fetchJasonData()
        //calling the main thred
        DispatchQueue.main.async {
            self.pins()
            self.forLoop()
        }
        
    }
    //This function is for getting the annotation view
    func mapView(_ mapView: MKMapView, viewFor annotation: MKAnnotation) -> MKAnnotationView? {
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
    func mapView(_ mapView: MKMapView, annotationView view: MKAnnotationView, calloutAccessoryControlTapped control: UIControl)
    {
        
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let destinationVC =  storyboard.instantiateViewController(withIdentifier: "detail") as! DetailsViewController
        
        for loc in buildingObject {

            if(view.annotation?.title == loc.BuildingName){
                destinationVC.Name = loc.BuildingName
                destinationVC.Facts = loc.Facts
                destinationVC.Image = loc.BuildingImage
            }
    }
        self.navigationController?.pushViewController(destinationVC, animated: true)
    }
    //This function will plot the pins
    func pins() {
        print("pins")
        for i in self.buildingObject
        {
            print(i)
            let location = CLLocationCoordinate2D(latitude: Double(i.Latitude!)!, longitude: Double(i.Longitude!)!)
            let region = MKCoordinateRegion(center: location, span: MKCoordinateSpan(latitudeDelta: 0.005, longitudeDelta: 0.005))
            self.mapView.setRegion(region, animated: true)
            let pin = customPin(pinTitle: i.BuildingName!, pinSubtitle: i.BuildingCode!, location: location)
            self.mapView.addAnnotation(pin)
            self.mapView.delegate = self
            
           
        }
    }
    //This function will draw the polyline from on annotation pin to another
    func forLoop()
    {
        for i in 0..<buildingObject.count
        {
            //we will run the loop until we are on the second last pin as we are drawing polyline from an annotion pin to the next annotation pin
            if(i < buildingObject.count-1)
            {
        let sourceLocation = CLLocationCoordinate2D(latitude: Double(buildingObject[i].Latitude!)! , longitude: Double(buildingObject[i].Longitude!)!)
         let destinationLocation = CLLocationCoordinate2D(latitude: Double(buildingObject[i+1].Latitude!)! , longitude: Double(buildingObject[i+1].Longitude!)!)
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
         self.mapView.add(route.polyline, level: .aboveRoads)
         let rect = route.polyline.boundingMapRect
         self.mapView.setRegion(MKCoordinateRegionForMapRect(rect), animated: true)
         
         }
        }
        }
    }
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        switch  status {
        case .denied, .restricted:
            print("no authorization")
        case .notDetermined:
            locMgr.requestWhenInUseAuthorization()
        default:
            locMgr.startUpdatingLocation()
        }
    }
    func mapView(_ mapView: MKMapView, rendererFor overlay: MKOverlay) -> MKOverlayRenderer {
        let render = MKPolylineRenderer(overlay: overlay)
        render.strokeColor = UIColor.red
        render.lineWidth = 4.0
        return render
    }
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        
        
        let newLocation = locations[0]
        
        // This will display the current location on the map
        let span:MKCoordinateSpan = MKCoordinateSpanMake(0.05, 0.05)
        let currentLocation:CLLocationCoordinate2D = CLLocationCoordinate2DMake(newLocation.coordinate.latitude, newLocation.coordinate.longitude)
        let region:MKCoordinateRegion = MKCoordinateRegionMake(currentLocation, span)
        mapView.setRegion(region, animated: true)
        self.mapView.showsUserLocation = true
        
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
                let buildingR = try Array (JSONDecoder().decode([[String:[Buildings]]].self, from: json))
                
                for (key,value) in buildingR[0]{
                    for i in value {
                        self.buildingObject.append(i)
                    }
                }
            }
            catch let jsonErr {
                print("Error Reading JSON: ", jsonErr)
            }
        }.resume()
    }
}


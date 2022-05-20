//
//  HotelTableViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/14/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
//i have used the flag of Sioux Fall as an app icon
import UIKit

class HotelTableViewController: UITableViewController {
 var hotel_obj = [Hotels]()

    override func viewDidLoad() {
        super.viewDidLoad()
        self.tableView.rowHeight = 140
        readPropertyList()
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    func readPropertyList()
    {
        let path = Bundle.main.path(forResource:"Hotel", ofType: "plist")!
        let hotels_array: NSArray = NSArray(contentsOfFile: path)!
        for item in hotels_array
        {
            let dictionary: [String: String] = (item as? Dictionary)!
            let hotel_name = dictionary["Name"]
            let hotel_address = dictionary["Address"]
            let hotel_price = dictionary["Price"]
            let hotel_star = dictionary["Star"]
            let hotel_aminities1 = dictionary["Aminities1"]
            let hotel_aminities2 = dictionary["Aminities2"]
            let hotel_aminities3 = dictionary["Aminities3"]
            let hotel_aminities4 = dictionary["Aminities4"]
            let hotel_aminities5 = dictionary["Aminities5"]
            let hotel_aminities6 = dictionary["Aminities6"]
            let hotel_details = dictionary["Details"]
            let hotel_cellimage = dictionary["Cell_Image"]
            let hotel_image = dictionary["Image"]
            let hotel_website = dictionary["Website"]
            let hotel_phone = dictionary["Phone"]
            
hotel_obj.append(Hotels(h_Name: hotel_name!, h_Address: hotel_address!, h_Price: hotel_price!, h_Aminities1: hotel_aminities1!, h_Aminities2: hotel_aminities2!, h_Aminities3: hotel_aminities3!, h_Aminities4: hotel_aminities4!, h_Aminities5: hotel_aminities5!, h_Aminities6: hotel_aminities6!, h_Cell_Image: hotel_cellimage!, h_Image: hotel_image!, h_Website: hotel_website!, h_Star: hotel_star!, h_Details: hotel_details!, h_Phone: hotel_phone!))
            }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return hotel_obj.count
    }
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let hotel:Hotels = hotel_obj[indexPath.row]
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell_hotels", for: indexPath)as! HotelTableViewCell
        let cellimage = UIImage(named: hotel.h_Cell_Image)
        cell.cellimage.image = cellimage
        cell.Name.text = hotel.h_Name
        cell.Address.text = hotel.h_Address
        cell.Price.text = hotel.h_Price
        cell.Star.text = hotel.h_Star
        

        // Configure the cell...

        return cell
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "SHOWDETAIL1")
        {
            let destVC = segue.destination as! HotelViewController
            if let indexPath = self.tableView.indexPathForSelectedRow
            {
                let hotel:Hotels = hotel_obj[indexPath.row]
                destVC.himage = hotel.h_Image
                destVC.hName = hotel.h_Name
                destVC.hAddress = hotel.h_Address
                destVC.hDetails = hotel.h_Details
                destVC.hAm1 = hotel.h_Aminities1
                destVC.hAm2 = hotel.h_Aminities2
                destVC.hAm3 = hotel.h_Aminities3
                destVC.hAm4 = hotel.h_Aminities4
                destVC.hAm5 = hotel.h_Aminities5
                destVC.hAm6 = hotel.h_Aminities6
                destVC.hprice = hotel.h_Price
                destVC.hweb = hotel.h_Website
                destVC.hphone = hotel.h_Phone
                
                
                
            }
        }
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCellEditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}

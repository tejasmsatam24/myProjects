//
//  TouristTableViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/14/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit


class TouristTableViewController: UITableViewController {
    var tourist_obj = [Tourist]()
    

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
        let path = Bundle.main.path(forResource: "Tourist", ofType: "plist")!
        let tourist_array: NSArray = NSArray(contentsOfFile: path)!
        
        for item in tourist_array
        {
             let dictionary: [String: String] = (item as? Dictionary)!
             let tourist_name = dictionary["Name"]
             let tourist_address = dictionary["Address"]
             let tourist_stars = dictionary["Stars"]
             let tourist_speciality = dictionary["Speciality"]
             let tourist_description = dictionary["Description"]
             let tourist_fees = dictionary["Fees"]
             let tourist_website = dictionary["Website"]
             let tourist_phone = dictionary["Phone"]
             let tourist_cellimage = dictionary["Cell-Image"]
             let tourist_Image = dictionary["Image"]
             tourist_obj.append(Tourist(t_Name: tourist_name!,t_Address: tourist_address!,t_Stars: tourist_stars!,t_Speciality: tourist_speciality!, t_Description: tourist_description!, t_Fees: tourist_fees!,t_Website: tourist_website!, t_Phone: tourist_phone!, t_CellImage: tourist_cellimage!, t_Image: tourist_Image!))
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
        return tourist_obj.count
    }
    
    
    

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let tourist:Tourist = tourist_obj[indexPath.row]
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell_tourist", for: indexPath) as! TouristTableViewCell
        let cellimage = UIImage(named: tourist.t_CellImage)
        cell.cellImage.image = cellimage
        cell.Name.text = tourist.t_Name
        cell.Address.text = tourist.t_Address
        cell.Speciality.text = tourist.t_Speciality
        cell.Stars.text = tourist.t_Stars
        

        // Configure the cell...

        return cell
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?)
    {
        // First identify the DetailViewController as the destination view controller
        print("inside send")
        if (segue.identifier == "SHOWDETAIL") {
            
            let destVC = segue.destination as! TouristViewController
            
            // Prepare to send park image, park name, state and entrance fees to the
            // DetailViewController
            if let indexPath = self.tableView.indexPathForSelectedRow {
                //print("inside send success")
                let tourist:Tourist = tourist_obj[indexPath.row]
                
                
               
                
                destVC.tname = tourist.t_Name
                destVC.tadd = tourist.t_Address
                destVC.timage = tourist.t_Image
                destVC.tphone = tourist.t_Phone
                destVC.tfees = tourist.t_Fees
                destVC.tweb = tourist.t_Website
                destVC.tdetail = tourist.t_Description
                
                
                
            } // end if
        } // end if
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

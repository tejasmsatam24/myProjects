//
//  ResturantTableViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class ResturantTableViewController: UITableViewController {
    var resturant_obj = [Resturant]()//creating an object of the class

    override func viewDidLoad() {
        super.viewDidLoad()
        self.tableView.rowHeight = 140//defining the height of the tables
        readPropertyList()//calling the function to read the property list

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    func readPropertyList()//defining a function to read from the property list
    {
        let path = Bundle.main.path(forResource:"Resturants", ofType: "plist")!//creating a path to the plist
        let resturant_array: NSArray = NSArray(contentsOfFile: path)!//creating an array to hold the contents of the plist
       //The loop will collect the data and store it in the defined array
        for item in resturant_array
        {
            let dictionary: [String: String] = (item as? Dictionary)!
            let res_name = dictionary["Name"]
            let res_add = dictionary["Address"]
            let res_spec = dictionary["Speciality"]
            let res_hour = dictionary["Hours"]
            let res_phone = dictionary["Phone"]
            let res_detail = dictionary["Detail"]
            let res_cell = dictionary["cell-image"]
            let res_image = dictionary["Image"]
            let res_web = dictionary["Website"]
            
            resturant_obj.append(Resturant(r_Name: res_name!, r_Address: res_add!, r_Speciality: res_spec!, r_Hours: res_hour!, r_Phone: res_phone!, r_Detail: res_detail!, r_Website: res_web!, r_cellimage: res_cell!, r_Image: res_image!))
            
            print("in")
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
        return resturant_obj.count
    }

    //we will pass the values to the outlets to display the contents
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let resturant:Resturant = resturant_obj[indexPath.row]
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell_rest", for: indexPath)as! ResturantTableViewCell
        print("in")
        let cimage = UIImage(named: resturant.r_cellimage)
        cell.cell_Image.image = cimage
        cell.Name.text = resturant.r_Name
        cell.Address.text = resturant.r_Address
        cell.Speciality.text = resturant.r_Speciality
        
        

        // Configure the cell...

        return cell
    }
    //we are using the below function to display pass the values to the ResturantDetailViewController
    override func prepare(for segue: UIStoryboardSegue, sender: Any?)
    {
        if(segue.identifier == "SHOWDETAIL2")
        {
            let destVC = segue.destination as! ResturantViewController
            if let indexPath = self.tableView.indexPathForSelectedRow
            {
                let resturant:Resturant = resturant_obj[indexPath.row]
                destVC.rimage = resturant.r_Image
                destVC.rname = resturant.r_Name
                destVC.raddress = resturant.r_Address
                destVC.rspeciality = resturant.r_Speciality
                destVC.rdetail = resturant.r_Detail
                destVC.rhour = resturant.r_Hours
                destVC.rphone = resturant.r_Phone
                destVC.rweb = resturant.r_Website
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

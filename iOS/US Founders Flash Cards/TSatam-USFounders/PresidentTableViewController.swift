//
//  PresidentTableViewController.swift
//  TSatam-USFounders
//
//  Created by Tejas Satam on 10/3/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
/*
 Author: Tejas M Satam
 ZID- Z1854197
 */
import UIKit

class PresidentTableViewController: UITableViewController {
//Creating an array
    var president_obj = [Presidents]()
  
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        
        self.tableView.rowHeight = 100
        
        readPropertyList()//calling the function to read the property list
        
        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    @objc func showAboutAppView()
    {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let controller = storyboard.instantiateViewController(withIdentifier: "AboutAppNavigationController") as! UINavigationController
        self.present(controller, animated: false, completion: nil)
    }
    
    func readPropertyList()//Definition of the function to read the Property List
    {
        let path = Bundle.main.path(forResource: "USFounders", ofType: "plist")!//giving the path for the P List
        let presidentArray: NSArray = NSArray(contentsOfFile:path)!
        print("\(presidentArray)")
        
        for item in presidentArray
        {
            let dictionary: [String: String] = (item as? Dictionary)!
            //creating constants to hold the contents of the P list
            let p_number = dictionary["Number"]
            let p_name = dictionary["Name"]
            let p_title = dictionary["Title"]
            let p_years = dictionary["Years"]
            let p_Spouse = dictionary["Spouse"]
            let p_Party = dictionary["Party"]
            let p_cellImage = dictionary["Image-cell"]
            let p_Image = dictionary["Image"]
            
            //Passing the constants
            president_obj.append(Presidents(President_Number: p_number!, President_Name: p_name!, President_Title: p_title!, President_Years: p_years!, President_Spouse_Name: p_Spouse!, President_Party: p_Party!, President_Cell_Image: p_cellImage!, President_Image: p_Image!))
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
        return president_obj.count
    }
    
    //Here the finction will display the labels and image
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell
    {
        let president:Presidents = president_obj[indexPath.row]
        let cell = tableView.dequeueReusableCell(withIdentifier: "CELL", for: indexPath) as! TableViewCell
        
        let cellImageName = UIImage(named: president.President_Cell_Image)
        cell.cellImageView.image = cellImageName
        cell.cellTitleLabel.text = president.President_Name
        cell.cellSubTitleLabel.text = president.President_Years
        
        return cell
        
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // First identify the DetailViewController as the destination view controller
        print("inside send")
        if (segue.identifier == "SHOWDETAIL") {
            
            let destVC = segue.destination as! DetailViewController
            
            // Prepare to send park image, park name, state and entrance fees to the
            // DetailViewController
            if let indexPath = self.tableView.indexPathForSelectedRow {
                //print("inside send success")
                let president:Presidents = president_obj[indexPath.row]
                
                /*print(president.President_Name)
                print(president.President_Title)
                print(president.President_Spouse_Name)
                print(president.President_Party)
                print(president.President_Image)*/
                
                destVC.presidentName = president.President_Name
                destVC.presidentImage = president.President_Image
                destVC.presidentspouse = president.President_Spouse_Name
                destVC.presidenttitle = president.President_Title
                destVC.presidentparty = president.President_Party
                
                
                
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

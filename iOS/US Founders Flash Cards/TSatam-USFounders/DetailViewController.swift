//
//  DetailViewController.swift
//  TSatam-USFounders
//
//  Created by Tejas Satam on 10/5/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
/*
 Author: Tejas M Satam
 ZID- Z1854197
 */
import UIKit

class DetailViewController: UIViewController {
    
    
    @IBOutlet weak var presidentImageView: UIImageView!
    @IBOutlet weak var presidentTitle: UILabel!
    @IBOutlet weak var presidentParty: UILabel!
    @IBOutlet weak var presidentSpouse: UILabel!
    
    // Variables to hold data passed from the TableViewController
    var presidentName:String!    // park name to pass to the website vc
    var presidentImage:String! // park image NAME
    //var presidentYears:String!     // state
    var presidenttitle:String!     // park hours
    var presidentspouse:String!      // entrance fees
    var presidentparty:String!   // park website
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Place sent data into their outlets
        navigationItem.title = presidentName
        presidentImageView.image = UIImage(named: presidentImage)
        presidentTitle.text = presidenttitle
        presidentParty.text = presidentparty
        presidentSpouse.text = presidentspouse
        
        
  
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}

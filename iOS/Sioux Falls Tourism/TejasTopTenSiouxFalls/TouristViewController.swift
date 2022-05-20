//
//  TouristViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/14/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class TouristViewController: UIViewController {

    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var address: UILabel!
    @IBOutlet weak var detail: UILabel!
    @IBOutlet weak var fees: UILabel!
    @IBOutlet weak var phone: UILabel!
    //@IBOutlet weak var web: UILabel!
    
    var timage: String!
    var tname: String!
    var tadd: String!
    var tdetail: String!
    var tfees: String!
    var tphone: String!
    var tweb: String!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = tname
        image.image = UIImage(named: timage)
        name.text = tname
        address.text = tadd
        detail.text = tdetail
        fees.text = tfees
        phone.text = tphone
        //web.text = tweb

        // Do any additional setup after loading the view.
    }
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "WWW") {
            let destVC = segue.destination as! WebsiteViewController
            //destVC.navigationItem.title = tvParkName + " National Park"
            destVC.parkwebsite = tweb
        }
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

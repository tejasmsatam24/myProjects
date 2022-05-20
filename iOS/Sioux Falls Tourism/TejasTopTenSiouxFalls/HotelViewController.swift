//
//  HotelViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class HotelViewController: UIViewController {
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var Name: UILabel!
    @IBOutlet weak var Address: UILabel!
    @IBOutlet weak var Details: UILabel!
    @IBOutlet weak var Am1: UILabel!
    @IBOutlet weak var Am2: UILabel!
    @IBOutlet weak var Am3: UILabel!
    @IBOutlet weak var Am4: UILabel!
    @IBOutlet weak var Am5: UILabel!
    @IBOutlet weak var Am6: UILabel!
    @IBOutlet weak var Price: UILabel!
    @IBOutlet weak var Website: UILabel!
    @IBOutlet weak var Phone: UILabel!
    
    var himage: String!
    var hName: String!
    var hAddress: String!
    var hDetails: String!
    var hAm1: String!
    var hAm2: String!
    var hAm3: String!
    var hAm4: String!
    var hAm5: String!
    var hAm6: String!
    var hprice: String!
    var hweb: String!
    var hphone: String!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = hName
        image.image = UIImage(named: himage)
        Name.text = hName
        Address.text = hAddress
        Details.text = hDetails
        Am1.text = hAm1
        Am2.text = hAm2
        Am3.text = hAm3
        Am4.text = hAm4
        Am5.text = hAm5
        Am6.text = hAm6
        Price.text = hprice
        Website.text = hweb
        Phone.text = hphone
        // Do any additional setup after loading the view.
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

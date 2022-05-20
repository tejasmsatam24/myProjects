//
//  ResturantViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class ResturantViewController: UIViewController {

    @IBOutlet weak var Image: UIImageView!
    @IBOutlet weak var Name: UILabel!
    @IBOutlet weak var Address: UILabel!
    @IBOutlet weak var Speciality: UILabel!
    @IBOutlet weak var Detail: UILabel!
    @IBOutlet weak var hours: UILabel!
    @IBOutlet weak var phone: UILabel!
    @IBOutlet weak var website: UILabel!
    
    var rimage: String!
    var rname: String!
    var raddress: String!
    var rspeciality: String!
    var rdetail: String!
    var rhour: String!
    var rphone: String!
    var rweb: String!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationItem.title = rname
        Image.image = UIImage(named: rimage)
        Name.text = rname
        Address.text = raddress
        Speciality.text = rspeciality
        Detail.text = rdetail
        hours.text = rhour
        phone.text = rphone
        website.text = rweb

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

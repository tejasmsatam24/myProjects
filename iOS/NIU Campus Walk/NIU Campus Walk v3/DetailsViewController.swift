//
//  DetailsViewController.swift
//  NIU Campus Walk v3
//
//  Created by Tejas Satam on 11/26/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class DetailsViewController: UIViewController {
    @IBOutlet weak var BuildingName: UILabel!
    @IBOutlet weak var BuildingFacts: UILabel!
    @IBOutlet weak var BuildImage: UIImageView!
    //creating the variables to store the data c
    var Name : String!
    var Facts: String!
    var Image: String!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //setting the labels
        BuildingName.text = Name
        BuildingFacts.text = Facts
        
        let url = URL(string: Image)
        DispatchQueue.main.async {
        let data = try? Data(contentsOf: url!)
        self.BuildImage.image = UIImage(data: data!)
        }
        //print("Success")
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }

}

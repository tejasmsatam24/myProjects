//
//  Hotels.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/14/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
//This class holds the variables for the Tourist

import UIKit
import Foundation

class Hotels: NSObject {
    var h_Name: String!
    var h_Address: String!
    var h_Price: String!
    var h_Star: String!
    var h_Aminities1: String!
    var h_Aminities2: String!
    var h_Aminities3: String!
    var h_Aminities4: String!
    var h_Aminities5: String!
    var h_Aminities6: String!
    var h_Details: String!
    var h_Cell_Image: String!
    var h_Image: String!
    var h_Website: String!
    var h_Phone: String!
    
    init(h_Name: String, h_Address: String, h_Price: String,h_Aminities1: String, h_Aminities2: String, h_Aminities3: String, h_Aminities4: String, h_Aminities5: String, h_Aminities6: String, h_Cell_Image: String, h_Image: String, h_Website:
        String, h_Star: String, h_Details: String, h_Phone: String)
    {
        self.h_Name = h_Name
        self.h_Address = h_Address
        self.h_Price = h_Price
        self.h_Star = h_Star
        self.h_Aminities1 = h_Aminities1
        self.h_Aminities2 = h_Aminities2
        self.h_Aminities3 = h_Aminities3
        self.h_Aminities4 = h_Aminities4
        self.h_Aminities5 = h_Aminities5
        self.h_Aminities6 = h_Aminities6
        self.h_Details = h_Details
        self.h_Cell_Image = h_Cell_Image
        self.h_Image = h_Image
        self.h_Website = h_Website
        self.h_Phone = h_Phone
        
        
    }
    
    
    
}

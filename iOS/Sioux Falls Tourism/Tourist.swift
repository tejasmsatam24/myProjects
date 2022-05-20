//
//  Tourist.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/13/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
//This class holds the variables for the Tourist
import UIKit
import Foundation

class Tourist: NSObject {
    var t_Name: String!
    var t_Address: String!
    var t_Stars: String!
    var t_Speciality: String!
    var t_Description: String!
    var t_Fees: String!
    var t_Website: String!
    var t_Phone: String!
    var t_CellImage: String!
    var t_Image: String!
    
    init(t_Name: String, t_Address: String, t_Stars: String, t_Speciality: String, t_Description: String, t_Fees: String, t_Website: String, t_Phone: String, t_CellImage: String, t_Image: String) {
        
        self.t_Name = t_Name
        self.t_Address = t_Address
        self.t_Stars = t_Stars
        self.t_Speciality = t_Speciality
        self.t_Description = t_Description
        self.t_Fees = t_Fees
        self.t_Website = t_Website
        self.t_Phone = t_Phone
        self.t_CellImage = t_CellImage
        self.t_Image = t_Image
        
        print(t_CellImage)
        
    }

}

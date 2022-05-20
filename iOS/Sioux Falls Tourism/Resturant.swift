//
//  Resturant.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
//creating the class for the Resturants
import UIKit
import Foundation

class Resturant: NSObject {
    var r_Name: String!
    var r_Address: String!
    var r_Speciality: String!
    var r_Hours: String!
    var r_Phone: String!
    var r_Detail: String!
    var r_Website: String!
    var r_cellimage: String!
    var r_Image: String!
    init(r_Name: String, r_Address: String, r_Speciality:String, r_Hours: String, r_Phone: String, r_Detail: String, r_Website: String, r_cellimage: String, r_Image: String)
    {
        self.r_Name = r_Name
        self.r_Address = r_Address
        self.r_Speciality = r_Speciality
        self.r_Hours = r_Hours
        self.r_Phone = r_Phone
        self.r_Detail = r_Detail
        self.r_Website = r_Website
        self.r_cellimage = r_cellimage
        self.r_Image = r_Image
        
    }

}

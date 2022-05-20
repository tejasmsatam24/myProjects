//
//  Presidents.swift
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
import Foundation

class Presidents: NSObject {
    //Definig Objects
    
    var President_Number: String!
    var President_Name: String!
    var President_Title: String!
    var President_Years: String!
    var President_Spouse_Name: String!
    var President_Party: String!
    var President_Cell_Image: String!
    var President_Image: String!
    
    init(President_Number: String, President_Name: String, President_Title: String, President_Years: String, President_Spouse_Name: String, President_Party: String, President_Cell_Image: String, President_Image: String)
    {
        self.President_Number = President_Number
        self.President_Name = President_Name
        self.President_Title = President_Title
        self.President_Years = President_Years
        self.President_Spouse_Name = President_Spouse_Name
        self.President_Party = President_Party
        self.President_Cell_Image = President_Cell_Image
        self.President_Image = President_Image
    }
    
    func printName(){
        print(self.President_Name)
    }
}

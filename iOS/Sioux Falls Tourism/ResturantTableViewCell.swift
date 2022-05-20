//
//  ResturantTableViewCell.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class ResturantTableViewCell: UITableViewCell {
    //creating the outlets for the cell
    @IBOutlet weak var cell_Image: UIImageView!
    @IBOutlet weak var Name: UILabel!
    @IBOutlet weak var Address: UILabel!
    @IBOutlet weak var Speciality: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}

//
//  HotelTableViewCell.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/14/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit

class HotelTableViewCell: UITableViewCell {
    @IBOutlet weak var cellimage: UIImageView!
    @IBOutlet weak var Name: UILabel!
    @IBOutlet weak var Address: UILabel!
    @IBOutlet weak var Price: UILabel!
    @IBOutlet weak var Star: UILabel!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}

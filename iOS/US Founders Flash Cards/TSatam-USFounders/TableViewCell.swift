//
//  TableViewCell.swift
//  TSatam-USFounders
//
//  Created by Tejas Satam on 10/5/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
/*
 Author: Tejas M Satam
 ZID- Z1854197
 */
import UIKit

class TableViewCell: UITableViewCell {

    //creating outlets for the view
    @IBOutlet weak var cellImageView: UIImageView!
     @IBOutlet weak var cellTitleLabel: UILabel!
    @IBOutlet weak var cellSubTitleLabel: UILabel!
    
   
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}

//
//  ViewController.swift
//  CallApp
//
//  Created by Tejas Satam on 10/3/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//


/*
 Author: Tejas Satam
 ZID :- Z1854197
*/

import UIKit

class ViewController: UIViewController {

    @IBAction func callButton(_ sender: UIButton) {
        
        //taking input as the sender's title
        guard let phoneNum = sender.titleLabel?.text else {return}
        
        //creating the link
        let myURL:NSURL = URL(string: "tel://\(phoneNum)")! as NSURL
        
        
        
        UIApplication.shared.open(myURL as URL, options: [:], completionHandler:nil)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}


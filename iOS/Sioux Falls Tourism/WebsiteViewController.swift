//
//  WebsiteViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
//This view controller shows the website when clicked on the "Visit Website" Button
import UIKit
import WebKit

class WebsiteViewController: UIViewController {
    @IBOutlet weak var parkweb: WKWebView!//creating the outlet for the web view
    var parkwebsite:String!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //here we will take the string from the view controller and convert it to url
        let myURL = URL(string: parkwebsite)
        
        let urlRequest = URLRequest(url: myURL!)
        
        parkweb.load(urlRequest)//loading the url file
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

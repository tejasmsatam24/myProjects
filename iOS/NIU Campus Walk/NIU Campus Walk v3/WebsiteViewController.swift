//
//  WebsiteViewController.swift
//  NIU Campus Walk v3
//
//  Created by Tejas Satam on 11/28/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit
import WebKit

class WebsiteViewController: UIViewController {

    @IBOutlet weak var website: WKWebView!
    
    var buildWeb:String!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //creating path to search index file
        let path = Bundle.main.path(forResource: "index", ofType: "html")!
        let webData: Data = try! Data(contentsOf:URL(fileURLWithPath: path))
        let html = NSString(data: webData, encoding: String.Encoding.utf8.rawValue)
        self.website.loadHTMLString(html! as String, baseURL: Bundle.main.bundleURL)
        
        
        
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

//
//  AboutAuthorViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/15/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit
import WebKit

class AboutAuthorViewController: UIViewController {
    @IBOutlet weak var Web: WKWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
navigationItem.title = "About Author"
        let path = Bundle.main.path(forResource: "index", ofType: "html")!//creating path to get the html file
        let webData: Data = try! Data(contentsOf: URL(fileURLWithPath: path))//creating a variable to hold the data of the HTML file
        let html = NSString(data: webData, encoding: String.Encoding.utf8.rawValue)
        
        // Load the webView outlet with the content of the index.html file
        self.Web.loadHTMLString(html! as String, baseURL: Bundle.main.bundleURL)//loading the webview
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

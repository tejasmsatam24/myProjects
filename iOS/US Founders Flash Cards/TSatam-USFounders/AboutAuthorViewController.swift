//
//  AboutAuthorViewController.swift
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
import WebKit
class AboutAuthorViewController: UIViewController {

    override func viewDidLoad() {
        
        super.viewDidLoad()
        navigationItem.title = "About Author"
        //creating the path for index.html
        let path = Bundle.main.path(forResource: "index", ofType: "html")!
        //capturing the data from the HTML File and storing in 'data'
        let data: Data = try! Data(contentsOf: URL(fileURLWithPath:path))
        //capture the content of the index file into the constant html
        let html = NSString(data: data,encoding:String.Encoding.utf8.rawValue)
        //displaying the contents of the html in the web view
        myWebView.loadHTMLString(html! as String, baseURL:Bundle.main.bundleURL)


        // Do any additional setup after loading the view.
    }
    
    
    @IBOutlet weak var myWebView: WKWebView!//creating an outlet for the web view
    
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

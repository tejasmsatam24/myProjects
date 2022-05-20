//
//  ViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/12/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//
//Here in the initial view i have created custom buttons that will direct us to the view controllers

import UIKit

class ViewController: UIViewController, UIScrollViewDelegate {

    //Here i have use pagecontrol and scroll view to hold and display multiple images
    @IBOutlet weak var pageControl: UIPageControl!
    @IBOutlet weak var scrollView: UIScrollView!
    var images: [String] = ["1","2","0"]
    var frame = CGRect(x:0,y:0,width:0,height:0)
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        pageControl.numberOfPages = images.count//setting the number of pages to the number of images in the array
        for index in 0..<images.count//setting the loop to display the images
        {
            frame.origin.x = scrollView.frame.size.width * CGFloat(index)
            frame.size = scrollView.frame.size
            let imageView = UIImageView(frame:frame)
            imageView.image = UIImage(named: images[index])
            self.scrollView.addSubview(imageView)
        }
        scrollView.contentSize = CGSize(width:(scrollView.frame.size.width * CGFloat(images.count)), height:scrollView.frame.size.height)
        scrollView.delegate = self
        addRightNavigationBarInfoButton()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    func scrollViewDidEndDecelerating(_ scrollView: UIScrollView) {
        let pageNumber = scrollView.contentOffset.x / scrollView.frame.size.width
        pageControl.currentPage = Int(pageNumber)
        
    }
    //creating a button at the top of title bar that directs us to the "About App" 
    func addRightNavigationBarInfoButton() {
        
        // Create an Info Dark button
        let button = UIButton(type: .infoDark)
        button.addTarget(self, action: #selector(self.showAboutAppView), for: .touchUpInside)
        
        // Place the button at the top right corner of the navigation bar
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(customView: button)
    }
    @objc func showAboutAppView() {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let controller = storyboard.instantiateViewController(withIdentifier: "AboutAppNavigationController") as! UINavigationController
        self.present(controller, animated: false, completion: nil)
        
    }
   
    
    @IBAction func button(_ sender: Any) {
    }
    
    


}


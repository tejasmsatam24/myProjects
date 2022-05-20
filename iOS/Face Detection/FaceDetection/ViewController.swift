//
//  ViewController.swift
//  FaceDetection
//
//  Created by Tejas Satam on 11/13/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit
import Vision
class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        guard let myImage = UIImage(named: "Jon Snow")
            else {return}
        //guard let myImage = UIImage(named: "Beatles")
        //else {return}
        //guard let myImage = UIImage(named:
        //"mtRushmore") else {return}
        let imageView = UIImageView(image: myImage)
        imageView.contentMode = .scaleAspectFit
        // Calculate image height.
        let scaleHeight = view.frame.width /
            myImage.size.width * myImage.size.height
        imageView.frame = CGRect(x: 0, y: 0, width:
            view.frame.width, height: scaleHeight)
        imageView.backgroundColor = .blue
        view.addSubview(imageView)
        // Create a request to detect only facial area.
        let myRequest = VNDetectFaceRectanglesRequest
        { (req, err) in
            
            //error)
            // Run the following block of code in the
            DispatchQueue.main.async {
                if let error = err {
                    print ("Failed to detect faces:",error)
                           return
                }
                //print(req)
                req.results?.forEach({(resp) in
                    guard let faceObservation = resp
                        as? VNFaceObservation else { return }
                    /* The following block of code calculates the red box
                     around the face. */
                    let X = self.view.frame.width *
                        faceObservation.boundingBox.origin.x
                    let ht = scaleHeight *
                        faceObservation.boundingBox.height
                    let Y = scaleHeight * (1 -
                        faceObservation.boundingBox.origin.y) - ht
                    let wd = self.view.frame.width *
                        faceObservation.boundingBox.width
                    let redView = UIView()
                    redView.backgroundColor = .red
                    redView.alpha = 0.35
                    redView.frame = CGRect(x: X, y: Y,
                                           width: wd, height: ht)
                    self.view.addSubview(redView)
                    //print(faceObservation.boundingBox)
                }) // end req results
            } // end Dispatch
        } // end myRequest
        guard let cgImage = myImage.cgImage else
            
        {return}
        // Execute the detection request (handler code)
        //in the background.
        DispatchQueue.global(qos: .background).async {
            let handler =
                VNImageRequestHandler(cgImage: cgImage, options: [:])
            do {
                try handler.perform([myRequest])
            } catch let requestError {
                print("Failed to perform request:",requestError)
            }
            
            } // end DispatchQueue
            } // end viewDidLoad()
            // Remove status bar
            override var prefersStatusBarHidden: Bool {
            return true
            } }


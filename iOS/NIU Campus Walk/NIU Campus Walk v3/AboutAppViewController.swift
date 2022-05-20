//
//  AboutAppViewController.swift
//  NIU Campus Walk v3
//
//  Created by Tejas Satam on 11/28/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit
import WebKit
import MessageUI

class AboutAppViewController: UIViewController, MFMailComposeViewControllerDelegate{
    
    @IBAction func feedback(_ sender: UIButton) {
        //Create view controller to compose the email using MFMailComposeViewController()
        let mailComposeVC = MFMailComposeViewController()
        //Make the mail compose view controller be its own delegate
        mailComposeVC.mailComposeDelegate = self
        //Need email address for one or more recipients
        let toRecipients = ["niucsci@gmail.com"]
        //need email message body in text/string
        let emailTitle = "US Presidents+"
        //connect/set the recipients to the mail compose view controller
        let messageBody = "Olsi Shehu, z1811296, Due: 11/08/2018"
        //connect set the subject title to the mail compose view controller
        mailComposeVC.setToRecipients(toRecipients)
        //connect/set the message body to the mail compose view controller
        mailComposeVC.setSubject(emailTitle)
        //connext/set the message body to the mail compose view controller
        mailComposeVC.setMessageBody(messageBody, isHTML: false)
        //present the mail compose view controller
        self.present(mailComposeVC, animated: true, completion: nil)
    }
    func mailComposeController(_ controller: MFMailComposeViewController, didFinishWith result: MFMailComposeResult, error: Error?) {
        //This will dismiss the feedback view
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
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

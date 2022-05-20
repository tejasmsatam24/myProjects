//
//  AboutAppViewController.swift
//  TejasTopTenSiouxFalls
//
//  Created by Tejas Satam on 10/13/18.
//  Copyright © 2018 Tejas Satam. All rights reserved.
//

import UIKit
import MessageUI

class AboutAppViewController: UIViewController,MFMailComposeViewControllerDelegate {
    @IBAction func feedback(_ sender: UIButton) {
        let mailcomposeVC = MFMailComposeViewController()//creating a new view controller to compose the email
        mailcomposeVC.mailComposeDelegate = self//making the view controller it's own delegate
        let toRecipents = ["tjssatam@gmail.com"]//Adding the recipents
        let emailTitle = "App Feedback"//This will be the title of the email
        let messageBody = "Feedback for Top 10 app v 1.0 Fall 2018"//This text will be on the body of the e-mail
        mailcomposeVC.setToRecipients(toRecipents)//connecting the recipents to the mailcomposer view
        mailcomposeVC.setSubject(emailTitle)//setting the title of the mail composer view
        mailcomposeVC.setMessageBody(messageBody, isHTML: false)//similarly setting thr body
        self.present(mailcomposeVC, animated: true, completion: nil)//present the email view
    }
    func mailComposeController(_ controller: MFMailComposeViewController, didFinishWith result: MFMailComposeResult, error: Error?)
    {
        self.dismiss(animated: true, completion: nil)//dismiss the email view
    }

    @IBAction func doneBar(_ sender:UIBarButtonItem)
    {
        self.dismiss(animated: true, completion: nil)
    }

    override func viewDidLoad() {
        super.viewDidLoad()
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

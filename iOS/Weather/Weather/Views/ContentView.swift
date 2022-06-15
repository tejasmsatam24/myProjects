//
//  ContentView.swift
//  Weather
//
//  Created by Tejas Satam on 6/15/22.
//

import SwiftUI

struct ContentView: View {
    @StateObject var locationManager = LocationManager()
    
    var body: some View {
        VStack {
            
            if let location = locationManager.location{
                Text("Your coordinates are: \(location.latitude), \(location.longitude)")
            }else{
                if(locationManager.isLoading){
                   LoadingView()
                }else{
                    WelcomeView().environmentObject(locationManager)
                }
            }
        }
        .background(Color(hue: 0.534, saturation: 0.355, brightness: 0.939))
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

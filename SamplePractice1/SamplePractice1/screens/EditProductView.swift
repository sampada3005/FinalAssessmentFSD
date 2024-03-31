//
//  EditProductView.swift
//  SamplePractice1
//
//  Created by Sampada Deshmukh on 31/03/24.
//

import SwiftUI

struct EditProductView: View {
    
    @State var title : String
    @State var description : String
    @State var price : String
    
    var body: some View {
        VStack{
            Form{
                Section("Product Details", content: {
                    TextField("Enter Product name", text: $title)
                    TextField("Enter Product Price", text: $description)
                    TextField("Enter Todo Description", text: $price)
                
                })
              
                Button(action: {
                   // await editProduct()
                }, label: {
                    Text("Edit Product").textCase(.uppercase)
                        .font(.system(size: 15, weight: .bold))
                        .foregroundColor(.white)
                        .frame(width: 250, height: 50)
                        .background(.blue)
                        .cornerRadius(10.0)
                })
            }
        }
    }
    
    
    func editProduct() async{
        
    }
}


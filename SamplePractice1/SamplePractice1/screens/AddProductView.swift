//
//  AddProductView.swift
//  SamplePractice1
//
//  Created by Sampada Deshmukh on 31/03/24.
//

import SwiftUI

struct AddProductView: View {
    @State var title = ""
    @State var description = ""
    @State var price = ""
    @State var categoty = ""
    
    var body: some View {
        VStack{
            Form{
                Section("Product Details", content: {
                    TextField("Enter Product name", text: $title)
                    TextField("Enter Product description", text: $description)
                    TextField("Enter Product Price", text: $price)
                        .keyboardType(.numberPad)
                    TextField("Enter Product Category", text: $categoty)
                
                })
              
                Button(action: {
                    Task{
                        await AddProduct()
                    }
                  
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
    
    
    func AddProduct() async{
        // Define the API endpoint URL
          let url = URL(string: "http://localhost:8082/api/v1/products/add")!

          // Create the request object
          var request = URLRequest(url: url)
          request.httpMethod = "POST"
          
          // Set the request body data
        let parameters: ProductPost = ProductPost(productName: title, price: Int(price), description: description)
        print(parameters)
          request.httpBody = parameters

          // Set the request headers if needed
          request.setValue("application/json", forHTTPHeaderField: "Content-Type")
          
          // Create the URLSession and define the data task
          let session = URLSession.shared
          let task = session.dataTask(with: request) { (data, response, error) in
              // Handle the response
              if let error = error {
                  print("Error: \(error.localizedDescription)")
                  return
              }

              // Check the response status code
              if let httpResponse = response as? HTTPURLResponse {
                  print("Status code: \(httpResponse.statusCode)")
              }

              // Handle the response data
              if let data = data {
                  if let responseString = String(data: data, encoding: .utf8) {
                      print("Response: \(responseString)")
                  }
              }
          }

          // Resume the task to execute the request
          task.resume()
    }
}

#Preview {
    AddProductView()
}

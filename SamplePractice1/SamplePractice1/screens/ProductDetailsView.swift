//
//  SwiftUIView.swift
//  SamplePractice1
//
//  Created by Sampada Deshmukh on 31/03/24.
//

import SwiftUI

struct ProductDetailsView: View {
    
    var productId : Int
    
    @State var productDetails: Product?
    
    var body: some View {
        NavigationView{
            VStack(){
                AsyncImage(
                    url: URL(string: "https://sample-videos.com/img/Sample-png-image-100kb.png"),
                    content: { image in
                        image.resizable()
                    },
                    placeholder: {
                        ProgressView()
                    }
                )
                .aspectRatio(contentMode: .fit)
                .frame(maxHeight: 300)
                .padding(.horizontal)
                Text(productDetails?.productName ?? "")
                    .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/)
                Text(productDetails?.description ?? "")
                    .fontWeight(.regular)
                    .padding(20)
                Spacer()
            }
            .toolbar{
                ToolbarItemGroup{
                  Image(systemName: "pencil")
                      .foregroundColor(.blue)
                  
                  Image(systemName: "trash")
                      .foregroundColor(.blue)
                }
            }
            .navigationTitle("Details")
        }
        .task {
           await getProductDetails()
           print(productDetails)
        }
       
    }
    
   
    func getProductDetails() async{
        guard let url = URL(string: "http://localhost:8081/api/v1/products/\(productId)") else{
            print("unable to get product")
            return
        }
        
        do{
            let (data, _) = try await URLSession.shared.data(from: url)
            let decodedData = try JSONDecoder().decode(ProductData.self, from: data)
            guard let payload = decodedData.payload else {
                return 
            }
            productDetails = payload
        }
        catch{
            print(error.localizedDescription)
        }
    }
}

//#Preview {
//    SwiftUIView()
//}

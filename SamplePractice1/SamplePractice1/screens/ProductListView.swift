//
//  ContentView.swift
//  SamplePractice1
//
//  Created by Sampada Deshmukh on 31/03/24.
//

import SwiftUI

struct ProductListView: View {
    
    @State var allProduct : [Product] = []
    
    var body: some View {
       
        NavigationView{
           
            List(allProduct){ item in
                NavigationLink(destination: {
                   // ProductDetailsView(productId : item.id ?? 0)
                    AddProductView()
                }, label: {
                    HStack(spacing: 20){
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
                        .frame(maxHeight: 40)
                        .padding(.horizontal)
                        VStack(alignment: .leading, spacing: 10){
                            Text(item.productName ?? "")
                                .fontWeight(.bold)
                            Text(item.description ?? "")
                                .fontWeight(.regular)
                                .lineLimit(/*@START_MENU_TOKEN@*/2/*@END_MENU_TOKEN@*/)
                        }
                    }
                })
                .listStyle(GroupedListStyle())
                .listRowBackground(Color.blue.opacity(0.2))
            }
            .navigationTitle("Products")
        }.task {
            await getProduct()
            print(allProduct)
        }
        
    }
    
    func deleteProduct()async{
        
    }
    
    func getProduct() async{
        guard let url = URL(string: "http://localhost:8082/api/v1/products/") else{
            print("unable to get product")
            return
        }
        
        do{
            let (data, _) = try await URLSession.shared.data(from: url)
            let decodedData = try JSONDecoder().decode(ProductResponse.self, from: data)
            guard let payload = decodedData.payload else {
                return
            }
            allProduct = payload
        }
        catch{
            print(error.localizedDescription)
        }
    }
}

#Preview {
    ProductListView()
}

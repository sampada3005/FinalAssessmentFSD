//
//  Product.swift
//  SamplePractice1
//
//  Created by Sampada Deshmukh on 31/03/24.
//

import Foundation

struct Product: Codable, Identifiable {
    let id: Int?
    let productName: String?
    let price: Int?
    let description: String?
    let category: String?
    
    init() {
            id = 0
            productName = ""
            price = 0
            description = ""
            category = nil
        }
}

struct ProductPost: Codable {
    let productName: String?
    let price: Int?
    let description: String?
}

struct ProductResponse: Codable {
    let payload: [Product]?
    let message: String?
    let status: String?
}

struct ProductData: Codable {
    let payload: Product?
    let message: String?
    let status: String?
}

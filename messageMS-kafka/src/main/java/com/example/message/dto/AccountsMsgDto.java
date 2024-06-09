package com.example.message.dto;


//For a record, bean is automatically created and all fields are final. The getter and setter methods are khud se generated too.
// The getter methods do not have the prefix "get", direct variable name se getter banta hai

/**
 * @param accountNumber
 * @param name
 * @param email
 * @param mobileNumber
 */
public record AccountsMsgDto(Long accountNumber, String name, String email, String mobileNumber) {
}

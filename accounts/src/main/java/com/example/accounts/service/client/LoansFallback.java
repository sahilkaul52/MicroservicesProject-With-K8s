package com.example.accounts.service.client;

import com.example.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient
{
    @Override
    public ResponseEntity<LoansDto> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;

        //If we dont add this fallback, the overall response would be a runtime exception even if the other ms are working fine
        //make sure fallback method itself does not call another ms bcs incase that ms fails too, there will be a problem
        //can send response from cache for web apps like facebook,instagram but not for banking applications
    }
}

package com.zupbootcamp.proposta.feing;

import com.zupbootcamp.proposta.feing.responses.AnaliseResponse;
import com.zupbootcamp.proposta.feing.requests.AnaliseRequest;
import com.zupbootcamp.proposta.models.Proposta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "Analise", url = "http://localhost:9999/api")
public interface AnaliseClient {
    @RequestMapping(method = RequestMethod.POST ,value = "/solicitacao/")
    AnaliseResponse analiseProposta(@RequestBody AnaliseRequest form);

}
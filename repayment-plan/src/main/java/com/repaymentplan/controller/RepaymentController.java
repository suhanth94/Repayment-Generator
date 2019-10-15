package com.repaymentplan.controller;

import com.repaymentplan.dto.RepaymentInputDTO;
import com.repaymentplan.dto.RepaymentOutputDTO;
import com.repaymentplan.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * RepaymentController - REST API
 */
@RestController
public class RepaymentController {

    @Autowired
    RepaymentService repaymentService;



    @RequestMapping(value = "/generate-plan", method = RequestMethod.POST)
    public ResponseEntity<List<RepaymentOutputDTO>> generatePlan(@RequestBody RepaymentInputDTO repaymentInputDTO){
        return ResponseEntity.ok().body(repaymentService.generatePlan(repaymentInputDTO));
    }
}

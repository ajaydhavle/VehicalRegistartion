package com.example.demo.Controller;

import com.example.demo.dto.VehicalDTO;
import com.example.demo.service.VehicalService;
import com.example.demo.service.VehicalServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class VehicalController {

    private static Logger LOGGER = LoggerFactory.getLogger(VehicalController.class);

    @Autowired
    VehicalService vehicalService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("This APi is used to test controller api")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello Test successful", HttpStatus.CREATED);
    }


   @PostMapping("/addVehical")
   public ResponseEntity<?> addVehical(@RequestBody VehicalDTO vehicalDTO){
       LOGGER.info("Enter into addVehical..");
       VehicalDTO vehicalDTO1= null;
       try {
           vehicalDTO1 = vehicalService.addAndUpdateVehicalDetails(vehicalDTO);
       } catch (Exception e){
        LOGGER.info("Exception while saving vehical deatils..",e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }

       return new ResponseEntity(vehicalDTO1,HttpStatus.CREATED);
   }

    @PostMapping("/updateVehical")
    public ResponseEntity<?> updateVehical(@RequestBody VehicalDTO vehicalDTO){
        LOGGER.info("Enter into updateVehical..");
        VehicalDTO vehicalDTO1= null;
        try {
            vehicalDTO1 = vehicalService.addAndUpdateVehicalDetails(vehicalDTO);
        } catch (Exception e){
            LOGGER.info("Exception while updating vehical deatils..");
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(vehicalDTO1,HttpStatus.CREATED);
    }

    @GetMapping("/getAllVehicalDtls")
    public ResponseEntity<?> getAllVehicalDtls(){
        LOGGER.info("Enter into getAllVehicalDtls..");
        List<VehicalDTO> vehicalDTOList= null;
        try {
            vehicalDTOList = vehicalService.getAllVehicalDeatils();
        } catch (Exception e){
            LOGGER.info("Exception while updating vehical deatils..");
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(vehicalDTOList,HttpStatus.OK);
    }

    @PostMapping("/getVehicalByRegNumber/{regNumber}")
    public ResponseEntity<?> getVehicalByRegNumber(@PathVariable String regNumber){
        LOGGER.info("Enter into updateVehical..");
        VehicalDTO vehicalDTO1= null;
        try {
            vehicalDTO1 = vehicalService.findVehicalDetailsByRegistrationNumber(regNumber);
        } catch (Exception e){
            LOGGER.info("Exception while fetching vehical deatils..");
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(vehicalDTO1,HttpStatus.CREATED);
    }

    @PostMapping("/deleteVehicalByRegNumber/{regNumber}")
    public ResponseEntity<?> deleteVehicalByRegNumber(@PathVariable String regNumber){
        LOGGER.info("Enter into deleteVehicalByRegNumber..");

        try {
            vehicalService.deleteVehicalDetailsByRegistrationNumber(regNumber);
        } catch (Exception e){
            LOGGER.info("Exception while deleting vehical deatils..");
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Deleted Successfully..",HttpStatus.OK);
    }
}

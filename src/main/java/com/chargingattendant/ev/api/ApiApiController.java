package com.chargingattendant.ev.api;

import com.chargingattendant.ev.api.ApiApi;
import com.chargingattendant.ev.model.BooleanResponse;
import com.chargingattendant.ev.model.ChargeStateResponse;
import com.chargingattendant.ev.model.ClimateStateResponse;
import com.chargingattendant.ev.model.DriveStateResponse;
import com.chargingattendant.ev.model.GuiStateResponse;
import com.chargingattendant.ev.model.VehicleStateResponse;
import com.chargingattendant.ev.model.VehiclesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;

@Controller
public class ApiApiController implements ApiApi {

    private static final Logger log = LoggerFactory.getLogger(ApiApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApiApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BooleanResponse> autoConditioningStart(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> autoConditioningStop(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> chargeMaxRange(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> chargeStart(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ChargeStateResponse> chargeState(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ChargeStateResponse>(objectMapper.readValue("{\n  \"response\" : {\n    \"battery_range\" : 239.02,\n    \"battery_level\" : 91,\n    \"charger_actual_current\" : 5,\n    \"charger_pilot_current\" : 40,\n    \"fast_charger_present\" : true,\n    \"charging_state\" : \"Complete\",\n    \"max_range_charge_counter\" : 5,\n    \"charge_rate\" : -1.0,\n    \"ideal_battery_range\" : 275.09,\n    \"battery_current\" : -0.6,\n    \"charger_voltage\" : 9.301444243932576,\n    \"charge_port_door_open\" : 6.027456183070403,\n    \"charge_starting_soc\" : 7.061401241503109,\n    \"time_to_full_charge\" : 2.3021358869347655,\n    \"charge_to_max_range\" : true,\n    \"charger_power\" : 0,\n    \"charge_starting_range\" : 1.4658129805029452,\n    \"est_battery_range\" : 155.79\n  }\n}", ChargeStateResponse.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ChargeStateResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ChargeStateResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> chargeStop(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ClimateStateResponse> climateState(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ClimateStateResponse>(objectMapper.readValue("{\n  \"result\" : {\n    \"driver_temp_setting\" : 22.6,\n    \"is_rear_defroster_on\" : false,\n    \"is_auto_conditioning_on\" : false,\n    \"outside_temp\" : 9.5,\n    \"inside_temp\" : 17.0,\n    \"passenger_temp_setting\" : 22.6,\n    \"fan_status\" : 0,\n    \"is_front_defroster_on\" : 0\n  }\n}", ClimateStateResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ClimateStateResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ClimateStateResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> doorLock(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> doorUnlock(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DriveStateResponse> driveState(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<DriveStateResponse>(objectMapper.readValue("{\n  \"response\" : {\n    \"shift_state\" : \"shift_state\",\n    \"heading\" : 6,\n    \"latitude\" : 37.4292,\n    \"speed\" : 0.8008281904610115,\n    \"gps_as_of\" : \"1359865301\",\n    \"longitude\" : 122.1381\n  }\n}", DriveStateResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DriveStateResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DriveStateResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> flashLights(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GuiStateResponse> guiSettings(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GuiStateResponse>(objectMapper.readValue("{\n  \"response\" : {\n    \"gui_distance_units\" : \"mi/hr\",\n    \"gui_range_display\" : \"Rated\",\n    \"gui_24_hour_time\" : false,\n    \"gui_charge_rate_units\" : \"mi/hr\",\n    \"gui_temperature_units\" : \"F\"\n  }\n}", GuiStateResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GuiStateResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GuiStateResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> honkHorn(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> mobileEnabled(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> remoteStartDrive(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> setChargeLimit(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id,@NotNull @ApiParam(value = "The percentage value", required = true) @Valid @RequestParam(value = "percent", required = true) String percent) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> setTemps(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id,@NotNull @ApiParam(value = "The desired temperature on the driver's side in celcius.", required = true) @Valid @RequestParam(value = "driver_temp", required = true) String driverTemp,@NotNull @ApiParam(value = "The desired temperature on the passenger's side in celcius.", required = true) @Valid @RequestParam(value = "passenger_temp", required = true) String passengerTemp) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> sunRoofControl(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id,@NotNull @ApiParam(value = "The desired state of the panoramic roof. The approximate percent\\ \\ open values for each state are `open` = 100%, `close` = 0%, `comfort`\\ \\ = 80%, and `vent` = ~15%", required = true) @Valid @RequestParam(value = "state", required = true) String state) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> trunkOpen(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id,@NotNull @ApiParam(value = "the trunk to open", required = true, allowableValues = "rear") @Valid @RequestParam(value = "which_trunk", required = true) String whichTrunk) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VehicleStateResponse> vehicleState(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<VehicleStateResponse>(objectMapper.readValue("{\n  \"response\" : {\n    \"df\" : false,\n    \"pr\" : false,\n    \"rt\" : false,\n    \"sun_roof_state\" : \"unknown\",\n    \"wheel_type\" : \"Base19\",\n    \"dr\" : false,\n    \"ft\" : false,\n    \"perf_config\" : \"Base\",\n    \"car_verson\" : \"1.19.42\",\n    \"sun_roof_percent_open\" : 0,\n    \"pf\" : false,\n    \"sun_roof_installed\" : false,\n    \"roof_color\" : \"Colored\",\n    \"dark_rims\" : false,\n    \"locked\" : true,\n    \"has_spoiler\" : false\n  }\n}", VehicleStateResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<VehicleStateResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VehicleStateResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<VehiclesResponse> vehicles() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<VehiclesResponse>(objectMapper.readValue("{\n  \"response\" : [ {\n    \"color\" : \"color\",\n    \"user_id\" : 123,\n    \"tokens\" : [ \"tokens\", \"tokens\" ],\n    \"vin\" : \"5YJSA1CN5CFP01657\",\n    \"state\" : \"online\",\n    \"id\" : 321,\n    \"display_name\" : \"Mein Model S\",\n    \"vehicle_id\" : \"1234567890\",\n    \"option_codes\" : \"MS01,RENA,TM00,DRLH,PF00,BT85,PBCW,RFPO,WT19,IBMB,IDPB,TR00,SU01,SC01,TP01,AU01,CH00,HP00,PA00,PS00,AD02,X020,X025,X001,X003,X007,X011,X013\"\n  }, {\n    \"color\" : \"color\",\n    \"user_id\" : 123,\n    \"tokens\" : [ \"tokens\", \"tokens\" ],\n    \"vin\" : \"5YJSA1CN5CFP01658\",\n    \"state\" : \"online\",\n    \"id\" : 321,\n    \"display_name\" : \"Mein Model 3\",\n    \"vehicle_id\" : \"1234554321\",\n    \"option_codes\" : \"MS01,RENA,TM00,DRLH,PF00,BT85,PBCW,RFPO,WT19,IBMB,IDPB,TR00,SU01,SC01,TP01,AU01,CH00,HP00,PA00,PS00,AD02,X020,X025,X001,X003,X007,X011,X013\"\n  } ],\n  \"count\" : 0\n}", VehiclesResponse.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<VehiclesResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<VehiclesResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BooleanResponse> wakeUp(@ApiParam(value = "The ID number of the car",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BooleanResponse>(objectMapper.readValue("{\n  \"response\" : true\n}", BooleanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BooleanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BooleanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}

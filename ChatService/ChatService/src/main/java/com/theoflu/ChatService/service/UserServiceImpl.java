package com.theoflu.ChatService.service;

import com.theoflu.ChatService.error.ResultMessage;
import com.theoflu.ChatService.serverReqs.ServerReqs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private  final ServerReqs serverReqs;
    @Override
    public ResultMessage returnUsername(String token) {
       String result= serverReqs.returnUsername(token).getBody().toString();
        if(result.equals("Invalid token")) {
            return new ResultMessage("Hatalı Token or Expired",404);
        }
        else if (result.equals("Missing or invalid Authorization header")) {
            return new ResultMessage("Guest",401);

        }
       return new ResultMessage(result,200);
    }


}

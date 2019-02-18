package com.nasi.portal.Task;

import com.nasi.portal.common.helper.MailUtil;
import com.nasi.portal.data.model.dict.SubjectStatus;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * created by xdCao on 2018/4/16
 */

public class EmailVeryfyTask implements Runnable {

    private String email;
    private String verifyCode;
    private String host;
    private Integer port;
    private String userName;
    private String pwd;

    public EmailVeryfyTask(String email, String verifyCode, String host, String port, String userName, String pwd) {
        this.email = email;
        this.verifyCode = verifyCode;
        this.host=host;
        this.port=Integer.parseInt(port);
        this.userName=userName;
        this.pwd=pwd;
    }

    @Override
    public void run() {
        try {
            MailUtil.send_mail(email,"Dear "+email+"： your verify code is "+verifyCode,host,port,userName,pwd);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }


}

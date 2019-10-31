//package com.prasaddy.entertainmentapp.controller;
//
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
//
//    @GetMapping("/")
//    public String home() {
//        return "Hello, User. Log In to the app <a href=\"oauth2/authorization/okta\">Log In</a>";
//    }
//
//    @GetMapping("/home")
//    public String home(@AuthenticationPrincipal OidcUser oidcUser) {
//        return "Welcome, " +oidcUser.getFullName() +".";
//    }
//
//    @GetMapping("/attributes")
//    @ResponseBody
//    public String attributes(@AuthenticationPrincipal OidcUser oidcUser) {
//        return oidcUser.getAttributes().toString();
//    }
//
//    @GetMapping("/authorities")
//    @ResponseBody
//    public String authorities(@AuthenticationPrincipal OidcUser oidcUser) {
//        return oidcUser.getAuthorities().toString();
//    }
//
//}

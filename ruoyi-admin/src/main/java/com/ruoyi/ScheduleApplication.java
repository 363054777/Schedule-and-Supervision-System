package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ScheduleApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ScheduleApplication.class, args);
        System.out.println("げんしん? スタート \n" +
                " .--.         _ _         .--. .---------------.    ____     __    \n" +
                " |  |        ( ' )        |  | `------------  /     \\   \\   /  / \n" +
                " \\  \\       (_ o _)       /  /        _ _ /  /       \\  _. /  ' \n" +
                "  \\  \\       (_,_)       /  /        ( ' )  /         _( )_ .'   \n" + 
                "   \\  \\     /  ^  \\     /  /        (_ o _)       ___(_ o _)'   \n" + 
                "    \\  \\   /  / \\  \\   /  /       /  (_,_)       |   |(_,_)'   \n" + 
                "     \\  \\ /  /   \\  \\ /  /       /  /            |   `-'  /    \n" + 
                "      \\ '-' /     \\ '-' /       /  ------------.  \\      /      \n" + 
                "       '---'       '---'       `---------------'   `-..-'          " );
    }
}
/*
 * .--.         _ _         .--. .---------------.    ____     __   
 * |  |        ( ' )        |  | `------------  /     \   \   /  /  
 * \  \       (_ o _)       /  /        _ _ /  /       \  _. /  '   
 *  \  \       (_,_)       /  /        ( ' )  /         _( )_ .'    
 *   \  \     /  ^  \     /  /        (_ o _)       ___(_ o _)'     
 *    \  \   /  / \  \   /  /       /  (_,_)       |   |(_,_)'      
 *     \  \ /  /   \  \ /  /       /  /            |   `-'  /       
 *      \ '-' /     \ '-' /       /  ------------.  \      /        
 *       '---'       '---'       `---------------`   `-..-'         
 */
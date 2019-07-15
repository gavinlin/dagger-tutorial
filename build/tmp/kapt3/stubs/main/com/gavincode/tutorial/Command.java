package com.gavincode.tutorial;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/gavincode/tutorial/Command;", "", "handleInput", "Lcom/gavincode/tutorial/Command$Status;", "input", "", "", "key", "Status", "dagger-tutorial"})
public abstract interface Command {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String key();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gavincode.tutorial.Command.Status handleInput(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> input);
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/gavincode/tutorial/Command$Status;", "", "(Ljava/lang/String;I)V", "INVALID", "HANDLED", "dagger-tutorial"})
    public static enum Status {
        /*public static final*/ INVALID /* = new INVALID() */,
        /*public static final*/ HANDLED /* = new HANDLED() */;
        
        Status() {
        }
    }
}
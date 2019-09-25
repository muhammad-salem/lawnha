package org.terminal.nio.unix;

import com.sun.jna.LastErrorException;
import com.sun.jna.Library;

public interface Libc extends Library {
      // termios.h
      int tcgetattr(int fd, Termios termios) throws LastErrorException;

      int tcsetattr(int fd, int opt, Termios termios) throws LastErrorException;

      // unistd.h
      int isatty(int fd);
}
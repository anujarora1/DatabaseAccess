#ifndef _LOGGER_H
#define _LOGGER_H

#include <fstream>

class Logger {

public:
    
    static Logger *getInstance();
    
    void write(std::string &msg);

    ~Logger();

private:
    static Logger *instance;
    
    std::fstream loggerStream;
    Logger();
    Logger(const Logger &theLogger);
};
#endif

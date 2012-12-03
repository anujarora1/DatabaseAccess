#ifndef _LOGGER_H
#define _LOGGER_H

class Logger {

public:
    
    static Logger *getInstance();
    
    void write(std::string &msg);

    ~Logger();

private:
    static Logger *instance;

    Logger();
    Logger(const Logger &theLogger);
};
#endif

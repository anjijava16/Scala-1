package ui

class UndefinedException(val symbol: String)
  extends JediException("Undefined identifier: " + symbol)
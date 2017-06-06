Program gauss;

Function gauss(upper: Integer): Integer;
    Begin
        If upper = 1
        Then gauss := 1
        Else gauss := gauss(upper-1) + upper
    End;

Var upper, result: Integer;
Begin
    In("Upper bound? ", upper);
    result := gauss(upper);
    Out("Result: ", result)
End.

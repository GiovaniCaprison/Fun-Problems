import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SentenceValidatorTest {

    @Test
    public void testValidSentence() {
        String validSentence = "This is a valid sentence.";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testInvalidSentenceStartsWithLowerCase() {
        String invalidSentence = "this starts with a lower case.";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testInvalidSentenceMissingTerminator() {
        String invalidSentence = "This sentence has no terminator";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testInvalidSentenceWithOddQuotes() {
        String invalidSentence = "This sentence has \"odd quotes.";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testValidSentenceWithEvenQuotes() {
        String validSentence = "This sentence has \"even\" quotes.";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testInvalidSentenceWithNumberBelow13() {
        String invalidSentence = "There are 12 months in a year.";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testValidSentenceWithNumberAbove12() {
        String validSentence = "There are 13 donuts in a baker's dozen.";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testInvalidSentenceWithNumberAndCharacters() {
        String invalidSentence = "It's expected to be 12a degrees today.";
        assertTrue(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testEmptyString() {
        String emptyString = "";
        assertFalse(SentenceValidator.isValidSentence(emptyString));
    }

    @Test
    public void testNullInput() {
        assertFalse(SentenceValidator.isValidSentence(null));
    }


    @Test
    public void testInvalidSentenceWithPeriodsInMiddle() {
        String invalidSentence = "This sentence. has a period in the middle.";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testInvalidSentenceWithoutCorrectTerminator() {
        String invalidSentence = "Does this end correctly,";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testValidSingleLetterSentence() {
        String validSentence = "A.";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testInvalidSingleLetterSentence() {
        String invalidSentence = "i?";
        assertFalse(SentenceValidator.isValidSentence(invalidSentence));
    }

    @Test
    public void testValidLongSentence() {
        String validSentence = "A\"gerhogherogheorigheriohg erhjg oierh gouierhg \"\"uersh giu shflgkjnert igun eiugn eriugn sleieurng iseurng iseurhg iserng iseurhg sljfngr eiuhg isuerng isuerhg sldjfgn seiurngs dkljfgn serieruhg speirfhg \" isejfng iseruhg seiufng liseurhg seuifng isuerhg seifhg isuerhg siuefng ilseurfhg sieurfhg sileurfhug liseurhg sefng sieurhg slerfiohg seruiohg seuirhg seifngritughs ifugh seriugh sdfgnret uighsd ifng siuhg sieurng sieurhg \"iseurhg ieurng iseurg isuengi userhgiusern iuserh g iuserngiu sreiug hsretiugn seriuthg isuernb giousern giurnb iusee ngiuserng iurth g!!!!!!!!!!!!!!!!!! iuserngi usehroigu nserriug nserioug bnsierurgbn oiserung lrtuhg is urngis uerhgi, userng iusnerbgl, kjrthg?????? ouisrtng ijrfngidru tghnidrjtngid 322312312 urtrngli usvnbkljrthigu ndrtiugn dirtunbg iujdrtb biu hndrtiug ndroituhg, oiudrstn g oiudr tg iurn biuo rnbgiu dbrntgiu nrdtioug ndriung oiurtn giurtng kujdrfgniu4t,tng iurh ng iurtn hiudrhtgykusrnfgli urhtgiu hrgiuh riutnh iusrthg niudrnthiuodrth buirt hipurnh iudrtnh liurthn giud\"rthn idurng ilrutn giurth giurh giun gkrjghnirutng idrutng iudrtn hgiudrnt hgioudrtng iur\"tnb iurbniru ttnb irutgn isrutng rtngh iudrtngh idruttng irutng irutnh ipurthgn iurtn iusrtng iurtnh irutng rtng hiruitngh rttnh ifugbnoritghn sirotngh priohtn goritn hriotnhg pdroitghn oruiotn oirotn odirtnbritonhg oirtngh oidrtnghijrtnhirutnh ifughiortnhiudr htn\".";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
        String invalidSentenceContainsSecondPeriod = "A\"gerhogherogheorigheriohg erhjg oierh gouierhg \"\"uersh giu shflgkjnert igun eiugn eriugn sleieurng iseurng iseurhg iserng iseurhg sljfngr eiuhg isuerng isuerhg sldjfgn seiurngs dkljfgn serieruhg speirfhg \" isejfng iseruhg seiufng liseurhg seuifng isuerhg seifhg isuerhg siuefng ilseurfhg sieurfhg sileurfhug liseurhg sefng sieurhg slerfiohg seruiohg seuirhg seifngritughs ifugh seriugh sdfgnret uighsd ifng siuhg sieurng sieurhg \"iseurhg ieurng iseurg isuengi userhgiusern iuserh g iuserngiu sreiug hsretiugn seriuthg isuernb giousern giurnb iusee ngiuserng iurth g!!!!!!!!!!!!!!!!!! iuserngi 13 usehroigu nserriug nserioug bnsierurgbn oiserung lrtuhg is urngis uerhgi, userng iusnerbgl, kjrthg?????? ouisrtng ijrfngidru tghnidrjtngid urtrngli usvnbkljrthigu ndrtiugn dirtunbg iujdrtb biu hndrtiug ndroituhg, oiudrstn g oiudr tg iurn biuo rnbgiu dbrntgiu nrdtioug ndriung 34r43 oiurtn giurtng kujdrfgniu4t,tng iurh ng iurtn hiudrhtgykusrnfgli urhtgiu hrgiuh riutnh iusrthg niudrnthiuodrth 45334 buirt hipurnh iudrtnh liurthn giud\"rthn idurng ilrutn giurth giurh giun gkrjghnirutng idrutng. iudrtn hgiudrnt hgioudrtng iur\"tnb iurbniru ttnb irutgn isrutng rtngh iudrtngh idruttng irutng irutnh ipurthgn iurtn iusrtng iurtnh irutng rtng hiruitngh rttnh ifugbnoritghn sirotngh priohtn goritn hriotnhg pdroitghn oruiotn oirotn odirtnbritonhg oirtngh oidrtnghijrtnhirutnh ifughiortnhiudr htn\".";
        assertFalse(SentenceValidator.isValidSentence(invalidSentenceContainsSecondPeriod));
    }

    @Test
    public void testValidSentenceWithEmbeddedQuotes() {
        String validSentence = "She said, \"When you're ready, come and get it!\", and left.";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testValidSentenceWithMultipleTerminators() {
        String validSentence = "Is this real or just a fantasy?!";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testValidSentenceWithNumbersAndPunctuation() {
        String validSentence = "In 2023, the world changed dramatically.";
        assertTrue(SentenceValidator.isValidSentence(validSentence));
    }

    @Test
    public void testInvalidSentenceWithSpecialCharacters() {
        String invalidSentence = "This is a special case @ symbol.";
        assertTrue(SentenceValidator.isValidSentence(invalidSentence));
    }
}



public class SvnRepoRevisionExtractor {

  public static void main(String[] args) {
    System.out.println "Starting in main"
    println getRevision()
  }

  public static String getRevision() {
    String revision = getSnippetOfOutputFromSvnInfo('Revision')
    return revision
  }

  public static String getSnippetOfOutputFromSvnInfo(String component,
                           String additionArgs = "") {
    String findSvnRepoUrl = "svn info $additionArgs "
    Process find = findSvnRepoUrl.execute()
    String text = find.text
    println "Found text $text"

    String pattern = /(?m)$component:\s*(.*)/
    def matchParts = (text =~ pattern)

    println "parts = " + matchParts
    return "JOSSE"
    // println "parts = " + matchParts[0]

    assert matchParts[0]?.size() == 2, "Could not find http $component of svn repo"
    String url = matchParts[0][1]

    return url
  }
}
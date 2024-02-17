package Self;

public class LinkedIn {

    public static void main(String[] args) {
        String[] skills = {
                "Data Analysis and Visualization",
                "SQL and Database Management",
                "Statistical Analysis",
                "Data Cleaning and Preprocessing",
                "Fundamental Java Programming",
        };

        String[] proficiencies = {
                "Business Intelligence",
                "Dashboard Design (Tableau, Power BI)",
                "Strong Analytical and Problem-Solving Skills"
        };

        /*String[] skills2 = {
                "Data Manipulation",
                "Data Analysis",
                "Data Visualization",
                "Analytical Thinking",
                "Problem-Solving",
                "Attention to Detail",
                "Adaptability",
                "Effective Communication",
                "Curiosity",
                "Teamwork",
                "Business Acumen",
                "Continuous Learning",
                "Leadership",
                "Project Management",
                "Domain Expertise",
                "Problem Identification",
                "Presentation Skills"
        };

        String[] proficiencies2 = {
                "Proficient in data manipulation, analysis, and visualization tools",
                "Critical thinking",
                "Ensuring data accuracy and precision",
                "Exploring and adapting to emerging tools and techniques",
                "Conveying complex findings with clarity",
                "Exploring data to seek valuable insights",
                "Thriving in a collaborative team setting",
                "Understanding the broader business context",
                "Commitment to ongoing personal and professional development",
                "Leading and mentoring junior analysts",
                "Managing complex data projects from inception to completion",
                "Deep knowledge of industry-specific trends and regulations",
                "Recognizing hidden issues and opportunities within data",
                "Delivering insightful presentations to executives and senior leadership"
        };*/
        displayBanner(skills, proficiencies);
    }

    private static void displayBanner(String[] skills, String[] proficiencies) {
        System.out.println("**************************************");
        System.out.println("*          Senior Data Analyst        *");
        System.out.println("*              Skills:                *");

        for (String skill : skills) {
            System.out.println("*  - " + skill);
        }

        System.out.println("*         Proficiencies:             *");

        for (String proficiency : proficiencies) {
            System.out.println("*  - " + proficiency);
        }

        System.out.println("**************************************");
    }
}


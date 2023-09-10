# CucuUIAutomationFramework
 SingleTon Obj Lazy loading and LISKOV Substitution Design Principle for PageObjectModel

 # CucuUIAutomationFramework
1. Execution starts at runner class which is annotated with @RunWith(Cucumber.class)
2. The runner class must have a path in @CucumberOptions for Steps and hooks classes. Its given through "glue"
3. Steps and Hooks classes get loaded by Cucumber.
   Make sure that Step and Hook classes are singleton classes so that only single object of each class get created 
4. Cucumber creates objects for Steps and Hook classes.
5. Initializing ExtenReport for each .feature file:
      a)Initialize extentreport for each feature file when the .feature file starts running, so check the feature file name running,
        If a feature file is running, meaning tosay that if all the scenarios of a feature file are run, then a new feature file
        runs, so check the name of the feature file running, and then initialize extent report for each feature file
        EX: Under Hooks.java, under @Before scenario which runs before every scenario check the feature file name

            if(!previousFeature.equalsIgnoreCase(currentFeature)){
               extentUtility.createExtentFeature(currentFeature);
               previousFeature = currentFeature;
            }
        Note: We can get the Feature name from scenario
        @Before
        public void beforeScenario(Scenario scenario){

   	      String projectLoc = envProps.getEnvProperty("projectLoc");
   	      currentFeature = scenario.getId();
   	      currentFeature = currentFeature.replace("file:///", "");
   	      currentFeature = currentFeature.replace(projectLoc, "");
   	      int indexOfLastSlash = currentFeature.lastIndexOf("/");
   	      currentFeature = currentFeature.substring(indexOfLastSlash+1, currentFeature.length());
   	      currentFeature = currentFeature.substring(0, currentFeature.indexOf(".feature:"));
   	
   	      System.out.println("Current Feature Name: " + currentFeature);

   	      if(!previousFeature.equalsIgnoreCase(currentFeature)){
   		     extentUtility.createExtentFeature(currentFeature);
   		     previousFeature = currentFeature;
   	      }
   	      extentUtility.createExtentScenario(scenario);
        }
        

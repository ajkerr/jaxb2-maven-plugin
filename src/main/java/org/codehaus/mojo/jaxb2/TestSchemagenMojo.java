/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.mojo.jaxb2;

import java.io.File;
import java.util.List;

import org.apache.maven.artifact.DependencyResolutionRequiredException;
import org.apache.maven.project.MavenProject;

/**
 * @author rfscholte
 * @goal testSchemagen
 * @phase generate-test-resources
 * @since 1.3
 */
public class TestSchemagenMojo
    extends AbstractSchemagenMojo
{

    /**
     * The source directories containing the test-source to be compiled.
     * 
     * @parameter expression="${project.testCompileSourceRoots}"
     * @required
     * @readonly
     */
    private List compileSourceRoots;

    /**
     * The working directory to place processor and javac generated class files.
     * 
     * @parameter expression="${project.build.directory}/generated-test-resources/schemagen"
     * @required
     */
    private File outputDirectory;

    @Override
    protected File getOutputDirectory()
    {
        return outputDirectory;
    }

    protected List getCompileSourceRoots()
    {
        return compileSourceRoots;
    }

    @Override
    protected List getClasspathElements( MavenProject project )
        throws DependencyResolutionRequiredException
    {
        return project.getTestClasspathElements();
    }
}

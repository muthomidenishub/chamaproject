<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page='View.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<link href="css/onlinehelp.css" rel="stylesheet">  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<div class="banner" style="margin-bottom: 30px">
    <h2>
        <a href="DashBoardIndex.html">Home</a>
        <i class="fa fa-angle-right"></i>
        <span>Need Help,check below</span>
    </h2>
</div>
<div class="grid-hor">

    <div class="grid-system">

        <div class="horz-grid">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        
                        <!--Help for treasurer-->
                        <div class="nav nav-pills faq-nav" id="faq-tabs" role="tablist" aria-orientation="vertical">
                            <a href="#" class="nav-link active" data-toggle="pill" role="tab" aria-controls="tab1" aria-selected="true">
                                <i class="fa fa-question"></i> How to ...
                            </a>
                            <a href="#tab5" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab2" aria-selected="false">
                                <i class="fa fa-user"></i> Add Member
                            </a>
                            <a href="#tab2" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab2" aria-selected="false">
                                <i class="fa fa-user"></i> Add Treasurer
                            </a>
                            <a href="#tab3" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab2" aria-selected="false">
                                <i class="fa fa-user"></i> Approve member Deletion
                            </a>


                            <a href="#tab7" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab6" aria-selected="false">
                                <i class="mdi mdi-help"></i> Adding Contribution
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="tab-content" id="faq-tab-content">
                            <div class="tab-pane show active" id="tab1" role="tabpanel" aria-labelledby="tab1">
                                <div class="accordion" id="accordion-tab-1">

                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-1-heading-2">
                                            <h5>
                                                <p>How to use the system</p>
                                            </h5>
                                        </div>

                                    </div>


                                </div>
                            </div>

                            <div class="tab-pane" id="tab2" role="tabpanel" aria-labelledby="tab3">
                                <div class="accordion" id="accordion-tab-2">
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-2-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Adding treasurer</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                            <div class="card-body">
                                                <p>Provide :</p>
                                                <ul class="list-group">
                                                    <li class="list-group-item"><p>A unique username;should only be characters or characters and numerals combined</p></li>
                                                    <li class="list-group-item"><p>Provide a valid email that can receive emails</p></li>

                                                </ul>

                                                <p><strong>Press Submit Button and the treasurer will be added into the system </strong></p>
                                            </div>
                                        </div>
                                    </div>



                                </div>
                            </div>
                             <div class="tab-pane" id="tab2" role="tabpanel" aria-labelledby="tab3">
                                <div class="accordion" id="accordion-tab-2">
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-2-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Adding treasurer</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                            <div class="card-body">
                                                <p>Provide :</p>
                                                <ul class="list-group">
                                                    <li class="list-group-item"><p>A unique username;should only be characters or characters and numerals combined</p></li>
                                                    <li class="list-group-item"><p>Provide a valid email that can receive emails</p></li>

                                                </ul>

                                                <p><strong>Press Submit Button and the treasurer will be added into the system </strong></p>
                                            </div>
                                        </div>
                                    </div>



                                </div>
                            </div>
                                 <div class="tab-pane" id="tab3" role="tabpanel" aria-labelledby="tab3">
                                <div class="accordion" id="accordion-tab-2">
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-2-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Adding treasurer</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                            <div class="card-body">
                                                <p>Press :</p>
                                                <ul class="list-group">
                                                    <li class="list-group-item"><p>Press approve delete member on the side nav</p></li>
                                                    <li class="list-group-item"><p>Press the red deletion button on the page</p></li>

                                                </ul>

                                                <p><strong>This action is irreversible</strong></p>
                                            </div>
                                        </div>
                                    </div>



                                </div>
                            </div>
                            <div class="tab-pane" id="tab5" role="tabpanel" aria-labelledby="tab3">
                                <div class="accordion" id="accordion-tab-3">
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-2-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Adding treasurer</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                            <div class="card-body">
                                                <p>Provide :</p>
                                                <ul class="list-group">
                                                    <li class="list-group-item"><p>A first name,second name,valid national id,valid phone number and a location</p></li>
                                                    <li class="list-group-item"><p><strong>Ensure the phone number and email address are valid</strong></p></li>
                                                    <li class="list-group-item"><p><strong>Press on the add button and member will be added successfully</strong></p></li>

                                                </ul>

                                            </div>
                                        </div>
                                    </div>



                                </div>
                            </div>
                            <div class="tab-pane" id="tab7" role="tabpanel" aria-labelledby="tab3">
                                <div class="accordion" id="accordion-tab-3">
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-2-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Begin Transactions</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                            <div class="card-body">
                                                <p>Provide :</p>
                                                <ul class="list-group">
                                                    <li class="list-group-item"><p>Press on the begin session to open member contribution</p></li>
                                                    <li class="list-group-item"><p><strong>This session is open till the treasurer closes the window</strong></p></li>
                                                    <li class="list-group-item"><p><strong>When session closes,all members who have not contributed will be penalised</strong></p></li>

                                                </ul>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-2-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Adding Contribution</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                            <div class="card-body">
                                                <p>Provide :</p>
                                                <ul class="list-group">
                                                    <li class="list-group-item"><p>A first name,second name,valid national id,valid phone number and a location</p></li>
                                                    <li class="list-group-item"><p><strong>Ensure the phone number and email address are valid</strong></p></li>
                                                    <li class="list-group-item"><p><strong>Press on the add button and member will be added successfully</strong></p></li>

                                                </ul>

                                            </div>
                                        </div>
                                    </div>



                                </div>
                     
               
                            <div class="tab-pane" id="tab6" role="tabpanel" aria-labelledby="tab6">
                                <div class="accordion" id="accordion-tab-6">
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-6-heading-1">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-6-content-1" aria-expanded="false" aria-controls="accordion-tab-6-content-1">Doomsday device?</button>
                                            </h5>
                                        </div>
                                        <div class="collapse show" id="accordion-tab-6-content-1" aria-labelledby="accordion-tab-6-heading-1" data-parent="#accordion-tab-6">
                                            <div class="card-body">
                                                <p>Ah, now the ball's in Farnsworth's court! We'll need to have a look inside you with this camera. Stop it, stop it. It's fine. I will 'destroy' you! Bender! Ship! Stop bickering or I'm going to come back there and change your opinions manually!</p>
                                                <p><strong>Example: </strong>So I really am important? How I feel when I'm drunk is correct?</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-6-heading-2">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-6-content-2" aria-expanded="false" aria-controls="accordion-tab-6-content-2">And so we say goodbye to our beloved pet, Nibbler?</button>
                                            </h5>
                                        </div>
                                        <div class="collapse" id="accordion-tab-6-content-2" aria-labelledby="accordion-tab-6-heading-2" data-parent="#accordion-tab-6">
                                            <div class="card-body">
                                                <p>Nibbler, who's gone to a place where I, too, hope one day to go. The toilet. But existing is basically all I do! I suppose I could part with 'one' and still be feared. I just told you! You've killed me!</p>
                                                <p><strong>Example: </strong>What's with you kids? Every other day it's food, food, food.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-6-heading-3">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-6-content-3" aria-expanded="false" aria-controls="accordion-tab-6-content-3">Tell her you just want to talk?</button>
                                            </h5>
                                        </div>
                                        <div class="collapse" id="accordion-tab-6-content-3" aria-labelledby="accordion-tab-6-heading-3" data-parent="#accordion-tab-6">
                                            <div class="card-body">
                                                <p>It has nothing to do with mating. Soon enough. There, now he's trapped in a book I wrote: a crummy world of plot holes and spelling errors! Daylight and everything. Hey! I'm a porno-dealing monster, what do I care what you think?</p>
                                                <p><strong>Example: </strong>Is that a cooking show? It doesn't look so shiny to me. And why did 'I' have to take a cab?</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card">
                                        <div class="card-header" id="accordion-tab-6-heading-4">
                                            <h5>
                                                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-6-content-4" aria-expanded="false" aria-controls="accordion-tab-6-content-4">Good man. Nixon's pro-war and pro-family?</button>
                                            </h5>
                                        </div>
                                        <div class="collapse" id="accordion-tab-6-content-4" aria-labelledby="accordion-tab-6-heading-4" data-parent="#accordion-tab-6">
                                            <div class="card-body">
                                                <p>I don't 'need' to drink. I can quit anytime I want! THE BIG BRAIN AM WINNING AGAIN! I AM THE GREETEST! NOW I AM LEAVING EARTH, FOR NO RAISEN! There's one way and only one way to determine if an animal is intelligent. Dissect its brain!</p>
                                                <p><strong>Example: </strong>Guess again. Yeah, I do that with my stupidness. And when we woke up, we had these bodies.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page='viewh.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
